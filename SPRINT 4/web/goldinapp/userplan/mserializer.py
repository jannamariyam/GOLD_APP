from rest_framework import serializers
from .models import Userplan
class mserializer(serializers.ModelSerializer):

    class Meta:
        model=Userplan
        fields='__all__'