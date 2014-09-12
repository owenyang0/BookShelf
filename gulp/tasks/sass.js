var gulp = require('gulp');
var sass = require('gulp-sass');

var config = require('../config/config');

module.exports = function() {
  gulp.src(config.files.stylesheets.main)
    .pipe(sass({
      // outputStyle: 'nested',
      sourceComments: 'normal',
      includePaths: config.files.stylesheets.src,
    }))
    .pipe(gulp.dest(config.files.stylesheets.dest))
};
