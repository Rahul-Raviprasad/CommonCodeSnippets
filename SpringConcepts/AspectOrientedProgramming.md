# Aspect oriented Programming.

Aspect-oriented programming is often defined  as  a technique that promotes separation of concerns within  a software system. Systems are  composed of several components, each responsible for a specific piece  of  functionality.  Often these components also  carry  additional responsibility  beyond  their  core functionality. System services such as logging, transaction management, and security often find their  way into components whose core responsibility is something else.
These system services are commonly referred to as  cross-cutting concerns  because they tend  to cut across multiple components in a  system.

By spreading these concerns across multiple components, you introduce two levels of  complexity to your code:
* The code that  implements the  systemwide  concerns is  duplicated across multiple  components. This  means that if you need  to  change  how those concerns work, you’ll  need  to  visit multiple  components. Even  if  you’ve abstracted  the concern to  a separate module  so that the  impact to your  components is a single method  call, that method  call is  duplicated  in multiple  places.
*  Your components  are  littered  with code  that  isn’t aligned with  their  core functionality.  A method to add an  entry to  an address book should only be concerned  with  how  to  add  the  address and not  with  whether  it’s  secure  or transactional.
