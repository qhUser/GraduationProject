package cn.gpmall.fast;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import cn.gpmall.common.utils.FastDFSClient;

public class FastDfsTest {
	@Test
    public void testUpload()throws Exception{
    	//创建一个配置文件。文件名任意，内容就是tracker服务器地址
    	//使用全局对象加载配置文件
    	ClientGlobal.init("I:/java毕业设计/e3-manager-web/src/main/resources/conf/client.conf");
    	//创建一个TrackerClient对象
    	TrackerClient trackerClient=new TrackerClient();
    	//通过TrackClient获得一个TrackerServer对象
    	TrackerServer trackerServer = trackerClient.getConnection();
    	//创建一个StrorageServer的引用，可以是null
    	StorageServer storageServer=null;
    	//创建一个StrorageClient,参数需要TrackerServer和StrorageServer
    	StorageClient storageClient=new StorageClient(trackerServer,storageServer);
    	//使用StorageClient上传文件
    	String[] string=storageClient.upload_file("C:/Users/Public/Pictures/Sample Pictures/p2.jpg", "jpg", null);
    	for(String s:string) {
    		System.out.println(s);
    	}
    }
	@Test
	public void testFastDfsClient() throws Exception{
		FastDFSClient fastDFSClient=new FastDFSClient("I:/java毕业设计/e3-manager-web/src/main/resources/conf/client.conf");
		String string = fastDFSClient.uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\p3.jpg");
	    System.out.println(string);
	
	}
	
}
