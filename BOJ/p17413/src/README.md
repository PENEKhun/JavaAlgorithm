# 단어 뒤집기 2

> 문제 번호 : 17413  
> 출처 : https://www.acmicpc.net/problem/17413

| 메모리 제한 | 시간 제한 |
|--------|-------|
| 512 MB | 1.0 초 |

## 문제 설명

<p>문자열 S가 주어졌을 때, 이 문자열에서 단어만&nbsp;뒤집으려고 한다.</p>
<p>먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.</p>
<ol>
 <li>알파벳 소문자('<code>a</code>'-'<code>z</code>'), 숫자('<code>0</code>'-'<code>9</code>'), 공백('<code> </code>'), 특수 문자('<code>&lt;</code>', '<code>&gt;</code>')로만 이루어져 있다.</li>
 <li>문자열의 시작과 끝은 공백이 아니다.</li>
 <li>'<code>&lt;</code>'와 '<code>&gt;</code>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<code>&lt;</code>'이 먼저 등장한다. 또, 두 문자의 개수는 같다.</li>
</ol>
<p>태그는 '<code>&lt;</code>'로 시작해서 '<code>&gt;</code>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<code>&lt;</code>'와 '<code>&gt;</code>'&nbsp;사이에는 알파벳 소문자와 공백만&nbsp;있다. 단어는 알파벳 소문자와&nbsp;숫자로 이루어진&nbsp;부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다. 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.</p>
