var gulp = require('gulp');
var cssmin = require('gulp-cssmin');
// var uglify = require('gulp-uglify');
var watch = require('gulp-watch');

gulp.task('minifyCSS', function(){
  gulp.src('./css/*.css')
  .pipe(cssmin())
  .pipe(gulp.dest('./css/dist'));
});

// gulp.task('minifyJS', function(){
//   gulp.src('./js/*.js')
//   .pipe(uglify())
//   .pipe(gulp.dest('./js/dist'));
// });

gulp.task('watch', function(){
  gulp.watch('./*.css', ['minifyCSS']);
  // gulp.watch('./*.js', ['minifyJS']);
});

gulp.task('default', ['minifyCSS', /*'minifyJS',*/ 'watch']);