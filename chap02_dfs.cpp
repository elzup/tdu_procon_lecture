#include <iostream>

int H, W;
int map[20][20];
int c;
using namespace std;

void printArray();
void check(int, int);

int main() {
  while (true) {
    cin  >> W >> H;
    // 両方 0 で終了
    if ((W | H) == 0) {
      break;
    }
    int sy, sx;
    for (int i = 0; i < H; i++) {
      string line;
      cin >> line;
      for (int j = 0; j < W; j++) {
        if (line[j] == '#') {
          map[i][j] = 1;          // 探索済みとする
        } else if (line[j] == '@') {
          // スタート地点を記録しておく
          sy = i;
          sx = j;
        }
      }
    }
    // printArray();  // 埋める前の確認
    c = 0;
    check(sy, sx);
    // printArray();  // デバッグ 埋めた後の確認
    cout << c << endl;
  }
  return 0;
}

// 再帰的に未探索を網羅する
void check(int y, int x) {
  // 未探索や対象外の範囲は探索しない
  if (y < 0 || x < 0 || y >= H || x >= W || map[y][x] == 1) {
    return;
  }
  map[y][x] = 1;
  c++;
  check(y + 1, x);
  check(y - 1, x);
  check(y, x + 1);
  check(y, x - 1);
}

void printArray() {
  for (int i = 0; i < H; i++) {
    for (int j = 0; j < W; j++) {
      cout << map[i][j];
    }
    cout << endl;
  }
}
