var gulp = require('gulp');
var sass = require('gulp-sass');

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

gulp.task('watch', ['sass'], function() {
  gulp.watch(config.files.stylesheets.src, ['sass'])
    .on('change', function(evt) {
      console.log(
        '[watcher] File ' + evt.path + ' was ' + evt.type + ', compiling...'
      );
    });
});

gulp.task('default', ['watch']);