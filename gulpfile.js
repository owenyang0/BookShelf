var gulp = require('gulp');
var sass = require('gulp-sass');
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

gulp.task('lint', function() {
  return gulp.src(config.files.javascript.src)
    .pipe(jshint())
    .pipe(jshint.reporter('default'));
});

var watchFiles = config.files.stylesheets.src.concat(config.files.javascript.src);
gulp.task('watch', ['sass'], function() {
  gulp.watch(watchFiles, ['sass', 'lint'])
    .on('change', function(evt) {
      console.log(
        '[watcher] File ' + evt.path + ' was ' + evt.type + ', compiling...'
      );
    });
});

gulp.task('default', ['watch']);
