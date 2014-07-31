var gulp = require('gulp');
var sass = require('gulp-sass');
var uglify = require('gulp-uglifyjs');
var jshint = require('gulp-jshint');

var config = require('./config.json');

gulp.task('sass', function() {
  gulp.src(config.files.stylesheets.main)
    .pipe(sass({
      // outputStyle: 'nested',
      sourceComments: 'normal',
      includePaths: config.files.stylesheets.src,
    }))
    .pipe(gulp.dest(config.files.stylesheets.dest))
});

gulp.task('uglify', function() {
  gulp.src(config.files.javascript.src)
    .pipe(uglify(config.files.javascript.destfile, {
      outSourceMap: true
    }))
    .pipe(gulp.dest(config.files.javascript.dest))
});

gulp.task('lint', function() {
  return gulp.src(config.files.javascript.src)
    .pipe(jshint())
    .pipe(jshint.reporter('default'));
});

gulp.task('build', ['sass', 'lint', 'uglify']);

var watchFiles = config.files.stylesheets.src.concat(config.files.javascript.src);
gulp.task('watch', ['build'], function() {
  gulp.watch(watchFiles, ['build'])
    .on('change', function(evt) {
      console.log(
        '[watcher] File ' + evt.path + ' was ' + evt.type + ', compiling...'
      );
    });
});

gulp.task('default', ['build']);
