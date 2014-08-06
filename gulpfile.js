var gulp = require('gulp');
var sass = require('gulp-sass');
var uglify = require('gulp-uglifyjs');
var jshint = require('gulp-jshint');
var imagemin = require('gulp-imagemin');
var gutil = require('gulp-util');

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

var imagefiles = config.files.images;
gulp.task('images', function() {
  return gulp.src(imagefiles.src)
    .pipe(imagemin({
      progressive: true
    }))
    .pipe(gulp.dest(imagefiles.dest));
});

gulp.task('build', ['sass', 'lint', 'uglify', 'images']);

var watchFiles = config.files.stylesheets.src.concat(
    config.files.javascript.src,
    imagefiles.src);

gulp.task('watch', ['build'], function() {
  gulp.watch(watchFiles, ['build'])
    .on('change', function(evt) {
      gutil.log(gutil.colors.red('File changed '), evt.path);
    });
});

gulp.task('default', ['build']);

gulp.task('test', function() {
  console.log(watchFiles);
})
