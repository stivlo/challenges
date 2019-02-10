

# https://www.youtube.com/watch?v=YstLjLCGmgg
# https://www.mathsisfun.com/games/towerofhanoi.html
class Hanoi:

    def __init__(self):
        self.move = 1

    def move_disk(self, from_rod: str, to_rod: str):
        print("#%d Moving disk from rod %s to rod %s" % (self.move, from_rod, to_rod))
        self.move += 1

    def move_tower(self, n: int, from_rod: str, to_rod: str, aux_rod: str):
        if n == 0:
            return
        self.move_tower(n - 1, from_rod, aux_rod, to_rod)
        self. move_disk(from_rod, to_rod)
        self.move_tower(n - 1, aux_rod, to_rod, from_rod)


Hanoi().move_tower(4, 'A', 'C', 'B')
