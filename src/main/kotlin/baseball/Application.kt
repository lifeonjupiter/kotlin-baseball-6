class Controller {
    val SIZE = 3
    val START_INCLUSIVE = 1
    val END_INCLUSIVE = 9
    val RETRY = 1
    val GAME_OVER = 2
    var gameService: GameService = GameService()
    @Throws(java.lang.IllegalArgumentException::class)
    fun run() {
        setGame()
        startGame()
        endGame()
        askRetry()
    }

    private fun setGame() {
        gameService.setGame(SIZE, START_INCLUSIVE, END_INCLUSIVE)
    }

    @Throws(java.lang.IllegalArgumentException::class)
    private fun startGame() {
        gameService.playGame()
    }

    private fun endGame() {
        SystemMessage.printGameOverMessage()
    }

    /**
     * 유저입력이 (문자 or 0 or 3 이상)  : Exception
     * 유저입력이 (1)                  : 재시작
     * 유저입력이 (2)                  : 종료
     */
    @Throws(java.lang.IllegalArgumentException::class)
    private fun askRetry() {
        RequestInput.printRetryMessage()
        if (inputNum == RETRY) {
            run()
        }
    }

    @get:Throws(java.lang.IllegalArgumentException::class)
    private val inputNum: Int
        private get() {
            val inputNum: Int = Console.readLine().toInt()
            if (inputNum == 0 || inputNum > GAME_OVER) {
                throw java.lang.IllegalArgumentException()
            }
            return inputNum
        }
}
git checkout -b lifeonjupiter
