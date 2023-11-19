<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <div class="card-header">
                        <h2 class="text-center">Login Form</h2>
                    </div>
                    <div class="card-body">
                        <form method="post" role="form" action="/login" class="form-horizontal">
                            <div class="mb-3">
                                <label for="username" class="control-label">Username:</label>
                                <input type="text" id="username" name="username" required class="form-control"
                                    placeholder="Enter login username" />
                            </div>

                            <div class="mb-3">
                                <label for="password" class="control-label">Password:</label>
                                <input type="password" id="password" name="password" required class="form-control"
                                    placeholder="Enter login password" />
                            </div>
                            <div class="mb-3">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <span>Not registered? <a href="/register/form">Register/Signup here</a></span>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
