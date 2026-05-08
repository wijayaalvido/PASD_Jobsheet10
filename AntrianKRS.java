public class AntrianKRS {
    MahasiswaKRS[] data;
    int front, rear, size, max;
    int totalDiproses;

    public AntrianKRS(int n) {
        max = n;
        data = new MahasiswaKRS[max];
        front = rear = -1;
        size = 0;
        totalDiproses = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void clear() {
        front = rear = -1;
        size = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }

    public void enqueue(MahasiswaKRS mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh!");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % max;
        }

        data[rear] = mhs;
        size++;
        System.out.println("Mahasiswa masuk ke antrian.");
    }

    public void dequeue2() {
        if (size < 2) {
            System.out.println("Antrian kurang dari 2 mahasiswa!");
            return;
        }

        System.out.println("Memproses 2 mahasiswa:");
        for (int i = 0; i < 2; i++) {
            data[front].tampilkanData();
            System.out.println("----------------------");
            front = (front + 1) % max;
            size--;
            totalDiproses++;
        }

        if (size == 0) {
            front = rear = -1;
        }
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Daftar seluruh antrian:");
        int i = front;
        for (int count = 0; count < size; count++) {
            System.out.println("Antrian ke-" + (count + 1));
            data[i].tampilkanData();
            System.out.println("----------------------");
            i = (i + 1) % max;
        }
    }

    public void peekFront2() {
        if (size < 2) {
            System.out.println("Antrian kurang dari 2 mahasiswa.");
            return;
        }

        System.out.println("2 Antrian terdepan:");
        int i = front;
        for (int count = 0; count < 2; count++) {
            data[i].tampilkanData();
            System.out.println("----------------------");
            i = (i + 1) % max;
        }
    }

    public void peekRear() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Antrian paling akhir:");
        data[rear].tampilkanData();
    }

    public void jumlahAntrian() {
        System.out.println("Jumlah antrian saat ini: " + size);
    }

    public void jumlahDiproses() {
        System.out.println("Jumlah mahasiswa sudah proses KRS: " + totalDiproses);
    }

    public void belumProses() {
        System.out.println("Jumlah mahasiswa belum proses KRS: " + size);
    }
}