var gulp = require('gulp'),
    cssmin = require('gulp-cssmin'),
    jsmin = require('gulp-uglify');

gulp.task('build-css', function(){
    gulp.src('dist/css/**/*.css')
    .pipe(cssmin())
    .pipe(gulp.dest('dist/css'));
});

gulp.task('build-js', function(){
    gulp.src('dist/js/**/*.js')
    .pipe(jsmin())
    .pipe(gulp.dest('dist/js'));
});

Gulp.self.task('watch', function(){
    Gulp.self.watch('./dist/js/**/*.js', ['jsmin']);
    Gulp.self.watch('dist/css/**/*.css', ['cssmin']);
});