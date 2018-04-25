var gulp = require('gulp'), 
cssmin = require('gulp-cssmin'),
jsmin = require('gulp-uglify'),
watch = require('gulp-watch');

gulp.task('min_css', function(){

gulp.src('assets/css/*.css')
	.pipe(cssmin())
        .pipe(gulp.dest('assets/dist'));
});

gulp.task('min_js', function(){

gulp.src('assets/js/*.js')
	.pipe(jsmin())
        .pipe(gulp.dest('assets/dist'));
});

gulp.task('watch', function() {
  gulp.watch('assets/css/*.css', ['min_css']);
  gulp.watch('assets/js/*.js', ['min_js']);
});
