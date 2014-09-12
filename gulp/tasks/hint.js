var gulp = require('gulp');
var jshint = require('gulp-jshint');

var config = require('../config/config');
var JS_SRC = config.files.javascript.src;

module.exports = function() {
  return gulp.src(JS_SRC)
    .pipe(jshint())
    .pipe(jshint.reporter('default'));
}
