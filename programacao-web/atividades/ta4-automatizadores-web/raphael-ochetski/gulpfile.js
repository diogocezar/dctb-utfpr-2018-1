var gulp = require('gulp'),
	cssmin = require('gulp-cssmin'),
	uglify = require('uglify-js');

gulp.task('build-js', function(){
	gulp.src('../FrameworkCSS/dist/js/*.js')
        .pipe(uglify())
        .pipe(gulp.dest('../FrameworkCSS/dist/js/*.js'))
	});
gulp.task('build-cssmin', function(){
	gulp.src('../FrameworkCSS/mystyle.css')
        .pipe(cssmin())
        .pipe(gulp.dest('../FrameworkCSS/mystyle.css'))
	});

