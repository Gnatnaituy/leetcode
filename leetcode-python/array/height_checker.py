from typing import List


def heightChecker(heights: List[int]) -> int:
    """
    48ms/28.15%/13.7MB/16.67%
    :param heights:
    :return:
    """
    sortedHeights = sorted(heights)
    res = 0
    for i in range(len(heights)):
        if sortedHeights[i] != heights[i]:
            res += 1

    return res
