var gulp = require('gulp'), 
cssmin = require('gulp-cssmin'),
jsmin = require('gulp-uglify'),
sassmin = require('gulp-sass');

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


gulp.task('build_sass', function(){
    gulp.src('assets/sass/*.scss')
    .pipe(sassmin())
    .pipe(gulp.dest('assets/css'));
});

gulp.task('default', ['min_css', 'min_js', 'build_sass']);

gulp.task('watch', function(){
    gulp.watch('assets/sass/*.scss', ['build_sass']);
});
