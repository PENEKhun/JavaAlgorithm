# 괄호의 값

> 문제 번호 : 2504  
> 출처 : https://www.acmicpc.net/problem/2504

| 메모리 제한 | 시간 제한 |
|--------|-------|
| 128 MB | 1.0 초 |

## 문제 설명

<p>4개의 기호 ‘<code>(</code>’, ‘<code>)</code>’, ‘<code>[</code>’, ‘<code>]</code>’를 이용해서 만들어지는 괄호열 중에서 올바른 괄호열이란 다음과 같이 정의된다.</p>
<ol>
 <li>한 쌍의 괄호로만 이루어진 ‘<code>()</code>’와 ‘<code>[]</code>’는 올바른 괄호열이다.</li>
 <li>만일 <code>X</code>가 올바른 괄호열이면 ‘<code>(X)</code>’이나 ‘<code>[X]</code>’도 모두 올바른 괄호열이 된다.</li>
 <li><code>X</code>와 <code>Y</code> 모두 올바른 괄호열이라면 이들을 결합한 <code>XY</code>도 올바른 괄호열이 된다.</li>
</ol>
<p>예를 들어 ‘<code>(()[[]])</code>’나 ‘<code>(())[][]</code>’ 는 올바른 괄호열이지만 ‘<code>([)]</code>’ 나 ‘<code>(()()[]</code>’ 은 모두 올바른 괄호열이 아니다. 우리는 어떤 올바른 괄호열 <code>X</code>에 대하여 그 괄호열의 값(괄호값)을 아래와 같이 정의하고 값(<code>X</code>)로 표시한다.</p>
<ol>
 <li>‘<code>()</code>’ 인 괄호열의 값은 2이다.</li>
 <li>‘<code>[]</code>’ 인 괄호열의 값은 3이다.</li>
 <li>‘<code>(X)</code>’ 의 괄호값은 2×값(<code>X</code>) 으로 계산된다.</li>
 <li>‘<code>[X]</code>’ 의 괄호값은 3×값(<code>X</code>) 으로 계산된다.</li>
 <li>올바른 괄호열 <code>X</code>와 <code>Y</code>가 결합된 <code>XY</code>의 괄호값은 값(<code>XY</code>)= 값(<code>X</code>)+값(<code>Y</code>) 로 계산된다.</li>
</ol>
<p>예를 들어 ‘<code>(()[[]])([])</code>’ 의 괄호값을 구해보자. ‘<code>()[[]]</code>’ 의 괄호값이 2 + 3×3=11 이므로 ‘<code>(()[[]])</code>’의 괄호값은 2×11=22 이다. 그리고 ‘<code>([])</code>’의 값은 2×3=6 이므로 전체 괄호열의 값은 22 + 6 = 28 이다.</p>
<p>여러분이 풀어야 할 문제는 주어진 괄호열을 읽고 그 괄호값을 앞에서 정의한대로 계산하여 출력하는 것이다.</p>
