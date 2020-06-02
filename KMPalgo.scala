package new1

import scala.util.control.Breaks._
import scala.io.Source
import java.io.File
import java.io.{BufferedWriter, FileWriter, File, PrintWriter}

object KMPalgo {
  def main(args:Array[String]){
    var s:String= (" ")
    var t:Char=s.charAt(0)
    
    var count:Int=0
    var j:Int=0
    var i:Int=0
    var n:Int=0
    
    var newArr = new Array[Char](100000000) 
    
   for(line <- Source.fromFile("pi.txt").getLines())
   {
     count+=1
     if(count>21)
     {
        var piArr= line.toCharArray()
        var m=piArr.length
        if(m>20)
        {
          for(i<-0 until m)
          {
            if(piArr(i)==t)
            {
              for(j<-i until (m-1))
              {
                piArr(j)=piArr(j+1)
              }
            }
          }
          for(i<-0 until 50)
          {
            newArr(i+n)=piArr(i)
            
          }
          n=n+50
        }  
     }
    
   }
    search(newArr,"971120")
    
//    search("ABABCABAB","ABABDABACDABABABCABAB")
  }
  
  def search(txt:Array[Char],pat:String)
  {
    var n:Int=pat.length()
    var m:Int=txt.length
    
    var lps= new Array[Int](n)
    searchLPS(pat,n,lps)
    
    var j=0
    var i=0
    while(i<m)
    {
      if(pat.charAt(j)==txt(i))
      {
        j+=1
        i+=1
      }
      if(j==n)
      {
//        println("pattern find in: "+(i-j))
            val fw=new FileWriter("Kmp.txt",true);
            fw.write("pattern found in index : "+(i-j)+"\n")   
            fw.close()
        j=lps(j-1)
      }
      else if(i<m && pat.charAt(j)!=txt(i))
      {
        if(j!=0)
        {
          j=lps(j-1)
        }
        else
        {
          i+=1
        }
      }
    }
  } 
    def searchLPS(pat:String,n:Int,lps:Array[Int])
    {
      var len=0
      var i=1
      lps(0)=0
      
      while(i<n)
      {
        if(pat.charAt(i)==pat.charAt(len))
        {
          len+=1
          lps(i)=len
          i+=1
        }else
        {
          if(len!=0)
          {
            len=lps(len-1)
          }else
          {
            lps(i)=0
            i+=1
          }
        }
      }
    }
  
}