var gulp = require('gulp');
var sass = require('gulp-sass');
var cssmin = require('gulp-cssmin');
var uglify = require('gulp-uglify');
var watch = require('gulp-watch');

gulp.task('default',['scss','css','js','watch']);

gulp.task('scss', function(){
    gulp.src('./assets/scss/pages/**/*.scss')
    .pipe(sass())
    .pipe(gulp.dest('./assets/css/src/pages'));
});

gulp.task('css', function(){
		gulp.src('./assets/css/src/**/*.css')
		.pipe(cssmin())
		.pipe(gulp.dest('./assets/css/dist'));
	});

gulp.task('js', function(){
		gulp.src(['./js/src/**/*.js', '!js/dist/**'])
		.pipe(uglify())
		.pipe(gulp.dest('./js/dist'))
	});

gulp.task('watch', function(){
    gulp.watch('./js/**/*.js', ['js']);
    gulp.watch('./assets/css/src/**/*.css', ['css']);
    gulp.watch('./assets/scss/**/*.scss', ['scss']);
	});