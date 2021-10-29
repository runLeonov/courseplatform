const grade = document.querySelector('.grade')
const nextLesson = document.querySelector('#next')
const nextPanel = document.querySelectorAll('.nL')
const numOfDoc = 0;


calc.onclick = function() {
    var myform = this.form
    let val = 0;
    val = +myform.var1.value + +myform.var2.value + 
    +myform.var3.value + +myform.var4.value + +myform.var5.value + 
    +myform.var6.value + +myform.var7.value + +myform.var8.value + 
    +myform.var9.value + +myform.var10.value
    grade.innerHTML = val
    if (val == 7 || val > 7) {
        nextLesson.classList.add('checked')
        nextLesson.href = '/courseplatform/src/main/resources/static/'+(numOfDoc+1)+'/index.html'
        nextPanel[numOfDoc+1].classList.remove('disable')
    }
}

res.onclick = () => {
    grade.innerHTML = 0
}

(function(){
    let a = document.querySelector('.right_panel'), b = null, P = 0;  // если ноль заменить на число, то блок будет прилипать до того, как верхний край окна браузера дойдёт до верхнего края элемента. Может быть отрицательным числом
    window.addEventListener('scroll', Ascroll, false);
    document.body.addEventListener('scroll', Ascroll, false);
    function Ascroll() {
      if (b == null) {
        let Sa = getComputedStyle(a, ''), s = '';
        for (let i = 0; i < Sa.length; i++) {
          if (Sa[i].indexOf('overflow') == 0 || Sa[i].indexOf('padding') == 0 || Sa[i].indexOf('border') == 0 || Sa[i].indexOf('outline') == 0 || Sa[i].indexOf('box-shadow') == 0 || Sa[i].indexOf('background') == 0) {
            s += Sa[i] + ': ' +Sa.getPropertyValue(Sa[i]) + '; '
          }
        }
        b = document.createElement('div');
        b.style.cssText = s + ' box-sizing: border-box; width: ' + a.offsetWidth + 'px;';
        a.insertBefore(b, a.firstChild);
        let l = a.childNodes.length;
        for (let i = 1; i < l; i++) {
          b.appendChild(a.childNodes[1]);
        }
        a.style.height = b.getBoundingClientRect().height + 'px';
        a.style.padding = '0';
        a.style.border = '0';
      }
      let Ra = a.getBoundingClientRect(),
          R = Math.round(Ra.top + b.getBoundingClientRect().height - document.querySelector('footer').getBoundingClientRect().top + 0);  // селектор блока, при достижении верхнего края которого нужно открепить прилипающий элемент;  Math.round() только для IE; если ноль заменить на число, то блок будет прилипать до того, как нижний край элемента дойдёт до футера
      if ((Ra.top - P) <= 0) {
        if ((Ra.top - P) <= R) {
          b.className = 'stop';
          b.style.top = - R +'px';
        } else {
          b.className = 'sticky';
          b.style.top = P + 'px';
        }
      } else {
        b.className = '';
        b.style.top = '';
      }
      window.addEventListener('resize', function() {
        a.children[0].style.width = getComputedStyle(a, '').width
      }, false);
    }
})()

const solution = document.querySelectorAll('.solution')
const sol1 = solution[0]
const sol2 = solution[1]
const p1 = document.querySelector('.p1')
const p2 = document.querySelector('.p2')

solution[0].onclick = function() {
  p1.classList.add('activepr')
  p1.classList.remove('hidepr')
}
solution[1].onclick = function() {
  p2.classList.add('activepr')
  p2.classList.remove('hidepr')
}

const collapse = document.querySelectorAll('.collapse')
const col1 = collapse[0]
const col2 = collapse[1]

collapse[0].onclick = function() {
  p1.classList.remove('activepr')
  p1.classList.add('hidepr')
}
collapse[1].onclick = function() {
  p2.classList.remove('activepr')
  p2.classList.add('hidepr')
}