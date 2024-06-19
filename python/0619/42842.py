def solution(brown, yellow):
    answer = []
    # brown = b_row * 2 + (b_col - 2) * 2
    # y_row = b_row - 2
    # y_col = b_col - 2
    # y_col * y_row = yellow
    for b_row in range(1, brown + 1):
         for b_col in range(1, brown + 1):
                if (b_row + b_col - 2) * 2 == brown:
                    if (b_row - 2) * (b_col - 2) == yellow:
                        if b_row >= b_col:
                            answer.append(b_row)
                            answer.append(b_col)
    return answer

print(solution(10, 2))