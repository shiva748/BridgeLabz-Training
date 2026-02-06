import java.util.Random;

public class DownloadManager {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new FileDownloader("Document.pdf"));
        Thread t2 = new Thread(new FileDownloader("Image.jpg"));
        Thread t3 = new Thread(new FileDownloader("Video.mp4"));

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.println("All downloads complete!");
    }
}

class FileDownloader implements Runnable {
    int progress;
    String fileName;
    Random random = new Random();

    public FileDownloader(String fileName){
        this.fileName = fileName;
        this.progress = 0;
    }

    private void download(){
        while(progress < 100){
            try{
                Thread.sleep(random.nextInt(500));
                progress = Math.min(progress + random.nextInt(10), 100);

                System.out.println(
                        "[" + Thread.currentThread().getName() + "] Downloading "
                                + fileName + ": " + progress + "%"
                );

            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void run() {
        System.out.println("Started downloading " + fileName);
        download();
        System.out.println(fileName + " Downloaded.");
    }
}
