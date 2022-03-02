from django.conf.urls import url
from reward import views
urlpatterns=[
    url(r'^post_re/',views.post_reward),
    url(r'^view_re/',views.view_reward,name='view_re'),
    url('update/(?P<idd>\w+)',views.update, name='up'),
    url(r'^redelete/(?P<idd>\w+)',views.del_reward,name='redelete'),
    url(r'^android1/',views.mapiview1.as_view()),
]