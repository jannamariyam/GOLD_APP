from rest_framework import serializers
from .models import Reward
class mserializer(serializers.ModelSerializer):

    class Meta:
        model=Reward
        fields='__all__'