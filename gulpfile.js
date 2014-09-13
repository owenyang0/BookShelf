var gulp = require('bookshelf-work-flow')([
  'hint',
  'sass',
  'uglify',
  'images',
  'setWatch',
  'watch'
]);

gulp.task('build', ['sass', 'hint', 'uglify', 'images']);
gulp.task('default', ['build']);
