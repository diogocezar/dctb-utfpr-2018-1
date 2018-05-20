var gulp = require('gulp'),
	cssmin = require('gulp-cssmin'),
	uglify = require('uglify-js');

gulp.task('build-js', function(){
	gulp.src('src/js/*.js')
        .pipe(uglify())
        .pipe(gulp.dest('src/js/*.js'))
	});
gulp.task('build-cssmin', function(){
	gulp.src('mystyle.css')
        .pipe(cssmin())
        .pipe(gulp.dest('mystyle.css'))
	});

