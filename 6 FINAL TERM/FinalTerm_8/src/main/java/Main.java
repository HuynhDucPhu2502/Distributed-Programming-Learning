import daos.AlbumDAO;
import utils.JPAUtil;

/**
 * Admin 5/16/2025
 **/
public class Main {

    public static void main(String[] args) {
        JPAUtil.getEntityManager();

        AlbumDAO albumDAO = new AlbumDAO();

//        System.out.println(albumDAO.updatePriceOfAlbum("AL1", 100));
//        albumDAO.listAlbumByGenre("po", 2021).forEach(System.out::println);
//        albumDAO.getNumberOfAlbumsByGenre().forEach((k, v) -> System.out.println(k + ": " + v));
    }


}
