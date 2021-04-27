/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom_sax_project2021;


/**
 *
 * @author jackiestewart
 */
public class Slam {
	private String name, year, winner, runnerUp, score, surface, semiFinalist, semiFinalist2;

    public Slam (){

    }

    public Slam(String name, String year, String winner, String runnerUp, String score, String surface, String semiFinalist, String semiFinalist2) {
		this.name = name;
                this.year = year;
		this.winner = winner;
		this.runnerUp = runnerUp;
		this.surface = surface;
                this.semiFinalist = semiFinalist;
		this.score = score;
                this.semiFinalist2 = semiFinalist2;

	}

    /*Slam(String name, String winner, String runnerUp, int score, String surface, String semiFinalist) {
        throw new UnsupportedOperationException("Not yet implemented");
    }*/
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Slam Details - \n");
		sb.append("Name:" + name);
		sb.append(",\n ");
                sb.append("Year:" + year);
		sb.append(",\n ");
		sb.append("Winner:" + winner);
		sb.append(",\n ");
		sb.append("RunnerUp:" + runnerUp);
		sb.append(",\n ");
                sb.append("Score:" + score);
		sb.append(",\n ");
		sb.append("Surface:" + surface);
		sb.append(",\n ");
                sb.append("SemiFinalist:" + semiFinalist);
		sb.append(",\n ");
                sb.append("SemiFinalist2:" + semiFinalist2);
		sb.append(".\n\n ");


		return sb.toString();
	}
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getYear()
    {
        return this.year;
    }
    public void setYear(String year)
    {
        this.year = year;
    }
     public String getWinner()
    {
        return this.winner;
    }
    public void setWinner(String winner)
    {
        this.winner = winner;
    }
    public String getRunnerUp()
    {
        return this.runnerUp;
    }
    public void setRunnerUp(String runnerUp)
    {
        this.runnerUp = runnerUp;
    }
    public String getScore()
    {
        return this.score;
    }
    public void setScore(String score)
    {
        this.score = score;
    }
     public String getSurface()
    {
        return this.surface;
    }
    public void setSurface(String surface)
    {
        this.surface = surface;
    }
    public String getSemiFinalist()
    {
        return this.semiFinalist;
    }
    public void setSemiFinalist(String semiFinalist)
    {
        this.semiFinalist = semiFinalist;
    }
     public String getSemiFinalist2()
    {
        return this.semiFinalist2;
    }
    public void setSemiFinalist2(String semiFinalist2)
    {
        this.semiFinalist2 = semiFinalist2;
    }
}