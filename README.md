#### ElectionResults

![ER-TCR](https://github.com/Pratiksha-Danake/ElectionResults/assets/111987794/2d013cee-9d5d-464a-aaa1-aca3d0d6bdef)

![ER-OUTPUT](https://github.com/Pratiksha-Danake/ElectionResults/assets/111987794/b6dbba40-d3ef-43bc-b942-6d12c45767bb)

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

### Analysis

- Assumptions
  - If data in line is not in required format code will Fail Fast by throwing Exception
  - Your yaml file must contain all the valid Constituencies and Parties names

#### Domain Modelling

##### Models

- Party Class

  - Attributes
    - String `name`
    - int `vote`
  - Behaviors
  - Party `create(String name, int vote)`:
    - Static method to create a new `Party` instance.

- Constituency Class
  - Attributes
    - String `name`
    - List<Party> `parties`
  - Behaviors
    - Constituency `create(String name, List<Party> parties)`
    - Static factory method to create a new `Constituency` instance.
    - `getName()`: String
    - List<Party> `getParties()`

##### Controllers

- ConstituencyController

  - Attributes
    - ConstituencyService `constituencyService`
      - A service instance used for managing constituency operations.
  - Behaviors
    - Response `createConstituency(String name, List<Party> parties)`
      - Creates a new constituency with the provided name and list of parties.
      - Returns a `Response` object indicating the status of the operation.
        -List<Constituency> `getConstituenciesData()`
      - Retrieves a list of all constituencies.

- PartyController
  - Attributes
    - PartyService `partyServic
      - A service instance used for managing party operations.
  - Behaviors
    - Response `createParty(String partyName, int voteCount)`
      - Returns a `Response` object indicating the status of the operation.

##### Domain Service

- WinnerEvaluatorService

  - Behaviors

    - List<WinnerPartyDto> `findWinner(List<Constituency> constituenciesData)`

      - Finds the winning party for each constituency from the given list of constituencies.
      - Returns a list of `WinnerPartyDto` objects, each representing the winner for a constituency.

    - WinnerPartyDto `getWinnerOfTheConstituency(List<Party> constituencyParties)`

      - Determines the winning party for a single constituency.
      - Returns a `WinnerPartyDto` object with the name of the winning party and the percentage of votes received.

    - double `getPercentageOfVotes(int totalVotes, int maxVotes)`
      - Calculates the percentage of votes received by the winning party.
      - Returns the percentage of votes rounded to two decimal places.

##### Outer Services

- DataReader

  - Attributes
    - DataParser `dataParser`
  - Behaviors
    - `readFile(String filePath)`: boolean
      - Reads data from the specified file path and processes each line.

- DataParser

  - Attributes
    - ConstituencyService `constituencyService`
  - Behaviors
    - boolean `parseInputLine(String line)`
      - Parses a single line of input data and creates the corresponding `Constituency` and `Party` objects.
      - Returns `true` if the operation is successful.

- ConstituencyService

  - Attributes
    - `constituencyRepository`: ConstituencyRepository
  - Behaviors
    - Constituency `createConstituency(String constituencyName, List<Party> parties)`
      - Creates a new `Constituency` with the provided name and list of parties.
    - List<Constituency> `getConstituenciesData()`
      - Retrieves a list of all constituencies.

- PartyService

  - Behaviors
    - Party `createParty(String partyName, int voteCount)`
      - Creates a new `Party` with the provided name and vote count.

- WinnerDetailsPrintingService

  - Behaviors
    - `print(List<WinnerPartyDto> winnerParties)`: void
      - Prints the details of the winning parties.

- ElectionResultsService Class
  - Attributes
    - `dataReader`: DataReader
    - `constituencyService`: ConstituencyService
    - `winnerEvaluatorService`: WinnerEvaluatorService
    - `winnerDetailsPrintingService`: WinnerDetailsPrintingService
  - Behaviors
    - void `evaluateElectionResults(String filePath)` - Evaluates the election results based on the input data from the specified file path. - Reads the file using `dataReader`. - Retrieves the constituencies data using `constituencyService`. - Finds the winners using `winnerEvaluatorService`. - Prints the winners using `winnerDetailsPrintingService`.
      l̥
