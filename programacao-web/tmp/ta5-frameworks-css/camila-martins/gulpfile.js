Gulp = {
  self : null,
  sass : null,
  init:function(){
    Gulp.self = require('gulp');
    Gulp.sass = require('gulp-sass');
    Gulp.scss();
    Gulp.default();
  },
  scss: function(){
    Gulp.self.task('scss', function(){
			console.log('[SASS] Compilando Arquivos do Sass');
			Gulp.self.src('./bootstrap/scss/*.scss')
			.pipe(Gulp.sass())
			.pipe(Gulp.self.dest('./bootstrap/compiler'));
    });
  },
  default: function(){
    Gulp.self.task('default',['scss']);
  },
  watch:  function(){
    Gulp.self.task('sass:watch', function () {
      Gulp.self.watch('./bootstrap/scss/*.scss', ['scss']);
    });
  }
};
Gulp.init();