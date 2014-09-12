var gulp = require('gulp');
var uglify = require('gulp-uglifyjs');

var config = require('../config/config');

module.exports = function() {
  gulp.src(config.files.javascript.src)
    .pipe(uglify(config.files.javascript.destfile, {
      outSourceMap: true
    }))
    .pipe(gulp.dest(config.files.javascript.dest))
};
