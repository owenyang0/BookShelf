var gulp = require('gulp');
var imagemin = require('gulp-imagemin');

var config = require('../config/config');
var IMG_FILES = config.files.images;

module.exports = function() {
  gulp.src(IMG_FILES.src)
    .pipe(imagemin({
      progressive: true
    }))
    .pipe(gulp.dest(IMG_FILES.dest));
};
