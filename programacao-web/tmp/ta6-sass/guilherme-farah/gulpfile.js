var gulp = require('gulp'),
    cssmin = require('gulp-cssmin'),
    jsmin = require('gulp-uglify'),
    sassmin = require('gulp-sass');

gulp.task('build-css', function(){
    gulp.src('./src/css/**/*.css')
    .pipe(cssmin())
    .pipe(gulp.dest('dist/css'));
});

gulp.task('build-js', function(){
    gulp.src('./src/js/**/*.js')
    .pipe(jsmin())
    .pipe(gulp.dest('dist/js'));
});

gulp.task('build-sass', function(){
    gulp.src('./src/sass/**/*.scss')
    .pipe(sassmin())
    .pipe(gulp.dest('src/css'));
});

gulp.task('default', ['build-css', 'build-js', 'build-sass']);

gulp.task('watch', function(){
    gulp.watch('./src/js/**/*.js', ['build-js']);
    gulp.watch('./src/css/**/*.css', ['build-css']);
    gulp.watch('./src/sass/**/*.scss', ['build-sass']);
});