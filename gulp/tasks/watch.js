var gulp = require('gulp');

var config = require('../config/config');

module.exports = function() {
  gulp.start(['build', 'setWatch']);

  gulp.watch(config.files.stylesheets.src, ['sass']);
  gulp.watch(config.files.javascript.src, ['hint', 'uglify']);
  gulp.watch(config.files.images.src, ['images']);
};