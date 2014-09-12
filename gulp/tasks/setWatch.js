var gulp = require('gulp');

module.exports = function() {
  gulp.conf = gulp.conf || {};
  gulp.conf.isWatching = true;

  return gulp;
};
