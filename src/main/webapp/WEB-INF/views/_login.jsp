
        <div class="form-box" id="login-box">
            <div class="header">LogIn</div>
            <form ng-submit="usuarioLoginCtrl.login(usuarioLoginCtrl.usuario)">
                <div class="body bg-gray">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Email" ng-model="usuarioLoginCtrl.usuario.email" name="email"/>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Senha" ng-model="usuarioLoginCtrl.usuario.senha"/>
                    </div>          
                    <div class="form-group">
                        <input type="checkbox" name="remember_me"/> Lembrar me
                    </div>
                </div>
                <div class="footer">                                                               
                    <button type="submit" class="btn bg-olive btn-block">Entrar</button>  
                    
                    <p><a href="#">Esqueci a senha</a></p>
                    
                    <a href="#/usuario/register" class="text-center">Criar nova conta</a>
                </div>
            </form>

            <div class="margin text-center">
                <span>Entrar com o Facebook</span>
                <br/>
                <button class="btn bg-light-blue btn-circle"><i class="fa fa-facebook"></i></button>
                <!-- <button class="btn bg-aqua btn-circle"><i class="fa fa-twitter"></i></button> -->
                <!-- <button class="btn bg-red btn-circle"><i class="fa fa-google-plus"></i></button> -->

            </div>
        </div>
