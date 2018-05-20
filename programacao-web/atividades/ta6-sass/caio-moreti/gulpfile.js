var gulp = require('gulp'),
sass = require('gulp-sass'),
watch = require('gulp-watch');

gulp.task('build-sass', function(){
	gulp.src('src/scss/*.scss').
	pipe(sass()).
	pipe(gulp.dest('src/css'));
});

gulp.task('watch', function() {
  gulp.watch('src/scss/*.scss', ['build-sass']);
});