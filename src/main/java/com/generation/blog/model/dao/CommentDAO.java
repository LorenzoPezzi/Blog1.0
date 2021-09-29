package com.generation.blog.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.generation.blog.model.entities.Comment;
import com.generation.util.Date;

public class CommentDAO extends AbstractDAOSQLite<Comment>{

	public CommentDAO(String table) throws ClassNotFoundException, SQLException {
		super(table);
	}

	@Override
	protected Comment _rowToObj(ResultSet rows) throws SQLException {
		return new Comment(rows.getInt("id"),rows.getString("title"),rows.getString("content"),rows.getString("author"),Date.toEuropean(rows.getString("dop")), rows.getInt("POSTID"));
	}

	@Override
	protected String _objToRow(Comment comm) {
		String sql = "INSERT INTO COMMENTS (TITLE, CONTENT, AUTHOR, DOP, POSTID) VALUES"
				+ "('[title]','[content]','[author]', '[dop]',[postid])";
		sql = sql.replace("[title]", comm.getTitle());
		sql = sql.replace("[content]", comm.getContent());
		sql = sql.replace("[author]", comm.getAuthor());
		sql = sql.replace("[dop]", comm.getDop().toAmerican());
		sql = sql.replace("[postid]", comm.getPostid()+"");
		return sql;
	}

}