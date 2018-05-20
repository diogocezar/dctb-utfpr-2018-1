var gulp = require('gulp');
var cssmin = require('gulp-cssmin');
var uglify = require('gulp-uglify');
var watch = require('gulp-watch');

gulp.task('default',['css','js','watch']);

gulp.task('css', function(){
		gulp.src('./assets/css/*.css')
		.pipe(cssmin())
		.pipe(gulp.dest('./assets/css/dist'));
	});

gulp.task('js', function(){
		gulp.src(['./js/*.js'])
		.pipe(uglify())
		.pipe(gulp.dest('./js/dist'))
	});

gulp.task('watch', function(){
		gulp.watch('./js/**/*.js', ['js']);
		gulp.watch('./assets/css/**/*.css', ['css']);
	});
