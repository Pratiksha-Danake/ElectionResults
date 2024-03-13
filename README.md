# ElectionResults

It's election night! Exciting! We have a feed of election results from a data supplier. 
They will supply us a file which will be updated throughout the night as results come in.

A result will consist of:
 - A constituency
 - A repeating set of pairs with the party code and the votes cast

So for example:

Banglore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP
Pune, INC, 9389, CPI, 4829, BJP, 3375, NCP, 3371, BSP, 309, IND

Party Codes -

BJP - Bhartiya Janta Party
INC - Indian National Congress
BSP - Bahujan Samaj Party
CPI - Communist Party of India
NCP - Nationalist Congress Party
IND - Independant

We want to transform this into a standard result that shows:
- the constituency name
- translates the party code into a full name
- shows the winner of the constituency

### State And Behaviours

#### class Result
- State
  - String constituencyName
  - List of PartyCode and votes cast

#### class DataSupplier
- List<Result> result

#### class DataAnalyzer extends DataSupplier
- State required to show result available from Base Class
  - String constituencyName
  - String partFullName
- State added by child class
  - String winnerOfConsistency

- Behaviour
  - void showWinner()

