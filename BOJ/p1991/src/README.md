# 트리 순회

> 문제 번호 : 1991  
> 출처 : https://www.acmicpc.net/problem/1991

## 문제 설명

<p>이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.</p>
<p style="text-align: center;"><img alt="" src="/JudgeOnline/upload/201007/trtr.png" style="height:220px; width:265px"></p>
<p>예를 들어 위와 같은 이진 트리가 입력되면,</p>
<ul>
 <li>전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)</li>
 <li>중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)</li>
 <li>후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)</li>
</ul>
<p>가 된다.</p>

