# 테트로미노

> 문제 번호 : 14500  
> 출처 : https://www.acmicpc.net/problem/14500

| 메모리 제한 | 시간 제한 |
|--------|-------|
| 512 MB | 2.0 초 |

## 문제 설명

<p>폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.</p>
<ul>
 <li>정사각형은 서로 겹치면 안 된다.</li>
 <li>도형은 모두 연결되어 있어야 한다.</li>
 <li>정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.</li>
</ul>
<p>정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.</p>
<p style="text-align:center"><a href="https://commons.wikimedia.org/wiki/File:All_5_free_tetrominoes.svg"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14500/1.png" style="height:167px; width:250px"></a></p>
<p>아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.</p>
<p>테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.</p>
<p>테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.</p>

