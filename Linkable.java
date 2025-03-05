/**
This is an iterface where the methods here will be implemented in ListNode
@author Ta'Rissa Woods
@ version %I% %G%
*/
public interface Linkable
{
   Comparable getValue();
   Linkable getNext();
   void setNext(Linkable next);
   void setValue(Comparable value);
}
