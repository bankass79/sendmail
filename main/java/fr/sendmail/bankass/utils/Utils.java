package fr.sendmail.bankass.utils;

public class Utils {



		
		public static final String ENCODING_ISO_8859_1 ="UTF-8"; //"ISO-8859-1";

		final static String NAMETABLE_EMAIL = "MAIL2";
		
		
		final static String UPDATE_CORPS_BY_ID="UPDATE "+Utils.NAMETABLE_EMAIL+" SET  corps= ?  WHERE id=?";
		
		final static String INSERT_LINE_EMAIL = "INSERT INTO  "+Utils.NAMETABLE_EMAIL+" (id, corps,idRegion) VALUES(? ,?, ?) ";
		

		final static String EMAIL_CORPS_SQL_BY_ID = "select corps, idRegion from "+NAMETABLE_EMAIL+" where id=?";
		final static String EMAIL_CORPS_SQL_BY_REGION = "select corps, id from "+NAMETABLE_EMAIL+" where idRegion=?";
		
		final static String EXIST_EMAIL_BY_ID = "select true from "+NAMETABLE_EMAIL+" where id=?";
		


}
