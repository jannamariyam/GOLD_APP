from django.conf.urls import url
from reward import views
urlpatterns=[
    url(r'^post_re/',views.post_reward),
    url(r'^view_re/',views.view_reward,name='view_re'),
    # url('updt_price/(?P<idd>\w+)',views.update, name='updt'),
    url(r'^redelete/(?P<idd>\w+)',views.del_reward,name='redelete'),
]