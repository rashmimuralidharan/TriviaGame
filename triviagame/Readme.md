
How to use this application?

This is a spring boot application. Below are the rest call that you can use to conduct the quiz.

Create user by making post call to http://localhost:8080/users
{
    "userId": "user1",
    "firstName": "rashmi",
    "lastName": "muralidharan",
    "state" : "active",
	"password": "test"
}

Create questions by making post call to http://localhost:8080/questions

{
	"questionId": "question1",
	"option1": "a",
	"option2": "b",
	"option3": "c",
	"option4": "d",
	"question": "abcd",
	"answer": "a"
}

Check if the user can login by doing a GET on http://localhost:8080/users/{userId}/password/{passwordText}

Get the id of the either the new quiz or the existing quiz by doing a GET on http://localhost:8080/getQuiz/{userId}

Find out if you can start the quiz by doing a GET on http://localhost:8080/canStartQuiz/{quizId}

Get the questions to display to the user by doing a GET on and finding out the quiz from your quiz id http://localhost:8080/quizzes

Find out if each answer is correct for any user as they navigate by doing get call on /isCorrectAnswer/{userId}/question/{questionId}/answer/{answerText}
	
