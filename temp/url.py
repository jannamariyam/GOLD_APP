from django.conf.urls import url
from temp import views
urlpatterns=[
    url('^adm/',views.adminhome),
    url('^login',views.login),

]