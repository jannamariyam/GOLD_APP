from django.conf.urls import url
from goldenstatus import views
urlpatterns=[
url('post_update/',views.post_update),
    url('view_update/',views.view_update),
    # url('update/(?P<idd>\w+)',views.update,name='update'),
    url(r'^update/', views.update, name='update'),
    url('delete/(?P<idd>\w+)',views.delete,name='delete'),
    url('add/',views.add),
]