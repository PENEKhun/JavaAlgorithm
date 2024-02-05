# 곱셈

> 문제 번호 : 1629  
> 출처 : https://www.acmicpc.net/problem/1629

## 문제 설명

<p>자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.</p>

## 임의의 B에서 A^B mod C 계산하기

### 1단계: 이진수 분해

B를 2의 거듭제곱으로 분해합니다. 맨 오른쪽 숫자부터 시작하여 k=0이고, 각 숫자에 대해 다음과 같이 처리합니다.

- 숫자가 1이면 2^k를 추가하고, 그렇지 않으면 추가하지 않습니다.
- K에 이 숫자의 자릿수 1을 추가하고, 다음 숫자를 처리하기 위해 왼쪽으로 움직입니다.

### 2단계: 거듭제곱의 mod C 계산

2 이상인 거듭제곱의 mod C 값을 계산합니다.

- \(5^1 \mod 19 = 5\)
- \(5^2 \mod 19 = 6\)
- \(5^4 \mod 19 = 17\)
- \(5^8 \mod 19 = 4\)
- \(5^{16} \mod 19 = 16\)
- \(5^{32} \mod 19 = 9\)
- \(5^{64} \mod 19 = 5\)

### 3단계: 모듈러 곱셈 성질을 이용한 결합

계산된 mod C 값을 결합하기 위해 모듈러 곱셈 성질을 이용합니다.

\[5^{117} \mod 19 = (5^1 \times 5^4 \times 5^{16} \times 5^{32} \times 5^{64}) \mod 19\]

\[5^{117} \mod 19 = (5^1 \mod 19 \times 5^4 \mod 19 \times 5^{16} \mod 19 \times 5^{32} \mod 19
\times 5^{64} \mod 19) \mod 19\]

\[5^{117} \mod 19 = (5 \times 17 \times 16 \times 9 \times 5) \mod 19\]

\[5^{117} \mod 19 = 61200 \mod 19 = 1\]

따라서 \(5^{117} \mod 19 = 1\)
